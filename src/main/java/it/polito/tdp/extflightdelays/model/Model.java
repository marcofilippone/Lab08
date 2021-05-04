package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private ExtFlightDelaysDAO dao;
	private Graph<Airport, DefaultWeightedEdge> grafo;
	private Map<Integer, Airport> idMap;
//	private Map<Connessione, Connessione> cMap;
	
	public Model() {
		dao = new ExtFlightDelaysDAO();
		idMap = new HashMap<>();
//		cMap = new HashMap<>();
	}
	
	public Graph<Airport, DefaultWeightedEdge> creaGrafo(int miglia) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		dao.loadAllAirports(idMap);
		Graphs.addAllVertices(this.grafo, idMap.values());
		double dM = 0;
		for(Connessione c : dao.getConnessioni(idMap)) {
			dM = c.getdTot()/c.getVoli();
			if(dM>=miglia) {
//				if(this.grafo.containsEdge(c.getB(), c.getA())) {
//					Connessione prova =
//					cMap.get
//				} else {
//					this.grafo.setEdgeWeight(c.getA(), c.getB(), dM);
//					cMap.put(new Connessione());
//				}
				if(this.grafo.containsEdge(c.getB(), c.getA())) {
//					DefaultWeightedEdge e = grafo.getEdge(c.getB(), c.getA());
//					double d = grafo.getEdgeWeight(e);
//					double dmedia = (d+dM)/2;
//					if(dmedia>miglia) {
//						grafo.setEdgeWeight(e, dmedia);
//					}
//					else {
//						grafo.removeEdge(e);
//					}
				} else {
					this.grafo.addEdge(c.getA(), c.getB());
					this.grafo.setEdgeWeight(c.getA(), c.getB(), dM);
				}
			}
		}
		//System.out.println("Grafo creato con "+grafo.vertexSet().size()+" vertici e "+grafo.edgeSet().size()+" archi");
		return this.grafo;
	}

}
