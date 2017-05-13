import static org.junit.Assert.*;

import org.junit.Test;

public class TestGrafo {

	@Test
	public void test() {

	}
	
//	@Test
//	public void testGrafonull() {
//		Grafo g = new Grafo();
//		g.addarista(true, 1, 2);
//		assertNull();
//	}
	
	@Test
	public void testGrafocorrecto() {
		Grafo g = new Grafo();
		g.addcuidad("argentina");
		g.addcuidad("brasil");
		g.addcuidad("canada");
		g.addcuidad("dinamarca");
		g.addcuidad("españa");
		g.addcuidad("francia");
		g.addcuidad("galicia");

		g.addarista(false, 0, 1);
		g.addarista(false, 0, 2);
		g.addarista(true, 1, 4);
		g.addarista(true, 1, 3);
		g.addarista(true, 2, 3);
		g.addarista(true, 2, 5);
		g.addarista(true, 3, 5);
		g.addarista(true, 3, 4);
		g.addarista(true, 4, 5);
		g.addarista(true, 4, 6);
		g.addarista(true, 5, 6);

		g.CaminoMinimo(0, 6, 4);
		assertEquals("[argentina to brasil, brasil to españa, españa to galicia]",
				g.CaminOptimo.Rutas.toString());
	}
	
	@Test
	public void testsinpeaje0() {
		Grafo g = new Grafo();
		g.addcuidad("argentina");
		g.addcuidad("brasil");
		g.addcuidad("canada");
		g.addcuidad("dinamarca");
		g.addcuidad("españa");
		g.addcuidad("francia");
		g.addcuidad("galicia");

		g.addarista(false, 0, 1);
		g.addarista(false, 0, 2);
		g.addarista(true, 1, 4);
		g.addarista(true, 1, 3);
		g.addarista(true, 2, 3);
		g.addarista(true, 2, 5);
		g.addarista(true, 3, 5);
		g.addarista(true, 3, 4);
		g.addarista(true, 4, 5);
		g.addarista(true, 4, 6);
		g.addarista(true, 5, 6);

		g.CaminoMinimo(0, 6, 0);
		assertEquals("[]",
				g.CaminOptimo.Rutas.toString());
	}
	

}
