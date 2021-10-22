package tests;

import java.util.ArrayList;
import java.util.List;

import model.daos.BandaDao;
import model.daos.DaoFactory;
import model.entitys.Banda;
import model.enums.Genero;

public class BandaTest {	
	public static void main(String[] args) {
		BandaDao bandaDao = DaoFactory.bandaDaoInstance();
	
		Banda bandaEntity = new Banda();
		
		//// Save Banda test ////
		
		bandaEntity.setNome("ABC");
		bandaEntity.setGenero(Genero.ROCK);
		
		System.out.println("=== Start ====");
		System.out.println();
		
		bandaDao.save(bandaEntity);
		
		System.out.println();
		System.out.println("=== End ====");
		

		//// List All Bandas test ////
		
		System.out.println();
		System.out.println("=== Start ====");
		
		List<Banda> bandas = bandaDao.findAll();
		for(Banda banda: bandas) {
			
			System.out.println(banda.getId());
			System.out.println(banda.getNome());
			System.out.println(banda.getGenero());
			
			System.out.println("=-=-=-=-=-=");
		}
		System.out.println();
		System.out.println("=== End ====");
		
		
		//// Find a Banda test ////
		/*
		System.out.println("=== Start ====");
		System.out.println();
		
		bandaEntity = bandaDao.findById(2L);
		
		System.out.println(bandaEntity.getId());
		System.out.println(bandaEntity.getNome());
		System.out.println(bandaEntity.getGenero());
		
		System.out.println();
		System.out.println("=== End ====");
		*/
		
		//// Update Banda test ////
		/*
		System.out.println("=== Start ====");
		System.out.println();
		
		bandaEntity.setGenero(Genero.FORRO);
		
		bandaDao.update(bandaEntity);
		System.out.println();

		System.out.println(bandaEntity.getId());
		System.out.println(bandaEntity.getNome());
		System.out.println(bandaEntity.getGenero());
		
		System.out.println();
		System.out.println("=== End ====");
		*/
		
		//// Delete Banda test ////
		/*
		System.out.println("=== Start ====");
		System.out.println();
		
		bandaDao.delete(bandaEntity);
		
		System.out.println();
		System.out.println("=== End ====");
		*/
		
		//// Find Banda With filter ////
		/*
		System.out.println();
		System.out.println("=== Start ====");
		
		ArrayList<Genero> generos = new ArrayList<>();
		generos.add(Genero.ROCK);
		generos.add(Genero.FORRO);

		List<Banda> bandas = bandaDao.findBandaByNameAndKind("A", generos);
		for(Banda banda: bandas) {
			
			System.out.println(banda.getId());
			System.out.println(banda.getNome());
			System.out.println(banda.getGenero());
			
			System.out.println("=-=-=-=-=-=");
		}
		System.out.println();
		System.out.println("=== End ====");
		*/
		
	}
}
