import java.util.ArrayList;                                                                                                                        
import java.util.Arrays;                                                                                                                           
import java.util.LinkedList;                                                                                                                       
                                                                                                                                                   
public class Hamilton {                                                                                                                    
                                                                                                                                                   
	private int v;                                                                                                                                 
	private LinkedList<Integer> adj[];                                                                                                             
                                                                                                                                                   
	public Hamilton(int v)  {                                                                                                              
		this.v = v;                                                                                                                                
		adj = new LinkedList[v];                                                                                                                   
		for (int i = 0; i < v; i++) {                                                                                                              
			adj[i] = new LinkedList<>();                                                                                                           
		}                                                                                                                                          
	}                                                                                                                                              
                                                                                                                                                   
	public void addEdge(int u, int v) {                                                                                                            
		adj[u].add(v);                                                                                                                             
		adj[v].add(u);                                                                                                                             
	}                                                                                                                                              
	                                                                                                                                               
	public void hamilton() {                                                                                                                       
		boolean[] visited = new boolean[v];                                                                                                        
		Arrays.fill(visited, false);                                                                                                               
		int source =0;                                                                                                                             
		ArrayList<Integer> res = new ArrayList<>();                                                                                                
		if(hamiltonUtil(source,visited,res,source)) {                                                                                              
			for(int i=0;i<res.size();i++) {                                                                                                        
				System.out.println(res.get(i));                                                                                                    
			}                                                                                                                                      
		}                                                                                                                                          
		else {                                                                                                                                     
			System.out.println("no suth path");                                                                                                    
		}                                                                                                                                          
		                                                                                                                                           
		                                                                                                                                           
	}                                                                                                                                              
	public boolean sourceSideVertex(int v,int source,boolean[] visited) {                                                                          
		for(int i:adj[v]) {                                                                                                                        
			if(i==source && visited[source]) {                                                                                                     
				return true;                                                                                                                       
			}                                                                                                                                      
		}                                                                                                                                          
		return false;                                                                                                                              
	}                                                                                                                                              
	private boolean hamiltonUtil(int u, boolean[] visited, ArrayList<Integer> res, int start) {                                                    
		visited[u]=true;                                                                                                                           
		res.add(u);                                                                                                                                
		                                                                                                                                           
		if(res.size()==v  ) {                                                                                                                      
			if(sourceSideVertex(res.get(res.size()-1), start, visited)) {                                                                          
				return true;                                                                                                                       
			}                                                                                                                                      
			return false;                                                                                                                          
		}                                                                                                                                          
		for(int i: adj[u]) {                                                                                                                       
			//System.out.println("i  "+i+"  u  "+u);                                                                                               
			if(!visited[i] ) {                                                                                                                     
				if(hamiltonUtil(i, visited, res, start)) {                                                                                         
					return true;                                                                                                                   
				}                                                                                                                                  
			                                                                                                                                       
				else {                                                                                                                             
					res.remove(Integer.valueOf(i));                                                                                                
					visited[i]=false;                                                                                                              
					                                                                                                                               
				}                                                                                                                                  
			}                                                                                                                                      
			                                                                                                                                       
			                                                                                                                                       
			                                                                                                                                       
		}                                                                                                                                          
		                                                                                                                                           
		return false;                                                                                                                              
		                                                                                                                                           
		                                                                                                                                           
	}                                                                                                                                              
	public static void main(String [] args) {                                                                                                      
		Hamilton g = new Hamilton(5);                                                                                              
		g.addEdge(0,1);                                                                                                                            
		g.addEdge(0,3);                                                                                                                            
		g.addEdge(1,2);                                                                                                                            
		g.addEdge(1,4);                                                                                                                            
		g.addEdge(2,4);                                                                                                                            
		g.addEdge(1,3);                                                                                                                            
		g.hamilton();                                                                                                                              
	}                                                                                                                                              
	                                                                                                                                               
}                                                                                                                                                  
                                                                                                                                                   