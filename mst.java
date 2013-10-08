import java.util.*;
/*
 * Author : Subhankar Mishra
 * Email  : mishra@cise.ufl.edu
 * Project: ADS Minimum Spanning Tree
 */

public class mst {
	public static int no_vertices = 0;
	public static int density = 0;
	public static ArrayList<HashMap<Integer, Integer>> adjacencies = new ArrayList<>();

	public static void main(String[] args) {
		int mode = checkMode(args);
		switch(mode){
		case 1: 
			//generateGraph(no_vertices,no_edges);
			break;
		case 2: 
			System.out.println("Simple Mode");
			break;
		case 3:
			System.out.println("Fibonacci Mode");
			break;
		default:
			System.out.println("No mode selected");
			break;
		}
	}

	public static void generateGraph(int vertices, int density){
		Random r = new Random();
		int counter = 0;
		int loop_max = (vertices * (vertices - 1) /2 )* density / 100;
		while (counter < loop_max){
			int i = r.nextInt(vertices);
			int j = r.nextInt(vertices);
			if (adjacencies.get(i).get(j) == 0){
				int w = r.nextInt(1000) + 1;
				adjacencies.get(i).put(j,w);
				counter++;
			}
		}
	}

	public static int checkMode(String[] args1){
		try{
			// Random mode
			if (args1[0].equals("-r")){ 
				// Grab the number of vertices
				try{
					if(isNumeric(args1[1])){
						no_vertices = Integer.parseInt(args1[1]);
						try{
							//Grab the number of edges
							if(isNumeric(args1[2])){
								density = Integer.parseInt(args1[2]);
								return 1;
							}
							else{
								System.out.println("Number of vertices [Argument 3] is not numeric");
							}
						}
						catch(Exception e){
							System.out.println(e.toString());
							System.out.println("Number of vertices [Argument 3] is missing");
						}
					}
					else{
						System.out.println("Number of vertices [Argument 2] is not numeric");
					}
				}
				catch(Exception e){
					System.out.println("Number of vertices [Argument 2] is missing");
				}
			}
			// User simple mode
			else if(args1[1].equals("-s")){
				System.out.println("User Simple Mode");
				return 2;
			}
			// User fibonacci mode
			else if(args1[1].equals("-f")){
				System.out.println("User Fibonacci Mode");
				return 3;
			}
			else{
				System.out.println("Please enter correct Argument 1: -r for random, -s for simple mode, -f for fibonacci mode");
				return 0;
			}
		}
		catch(Exception e){
			System.out.println("Please enter an argument: -r for random, -s for simple mode, -f for fibonacci mode");
			return 0;
		}
		return 0;
	}

	public static boolean isNumeric(String str)  
	{  
		try  
		{  
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}
}
