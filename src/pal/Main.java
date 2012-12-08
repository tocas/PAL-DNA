package pal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"cp1250"));
		String analfabet = br.readLine();
		String genG = br.readLine();
		int countMutation =  Integer.valueOf(br.readLine());
		String actualDNA = br.readLine();
		/*
		System.out.println(analfabet);
		System.out.println(genG);
		System.out.println(countMutation);
		System.out.println(actualDNA);
		*/
		int m = genG.length()+1;
		int n = actualDNA.length()+1;
		
		int[][] dist = new int[m][n];
		//inicalization tabale
		for(int i = 0 ; i < n;i++){
			dist[0][i] = 0;
		}
		for(int i = 1; i < m; i++){
			dist[i][0] = i	;
		}
		//iterate over rows
		for(int row = 1; row < m; row++){
			//iterate over collums
			for(int coll = 1; coll < n; coll++){
				//compute [row][coll]
				if(genG.charAt(row-1) == actualDNA.charAt(coll-1)) {
					dist[row][coll] = Math.min(dist[row-1][coll-1],dist[row-1][coll]+1);
					dist[row][coll] = Math.min(dist[row][coll], dist[row][coll-1]+1);
				} else {
					dist[row][coll] = Math.min(dist[row-1][coll] +1, dist[row][coll-1]+1);
				}
			}
		}
		
		/*for(int i = 0; i < genG.length()+1;i++){
			for(int j = 0; j < actualDNA.length() +1;j++){
				System.out.print(dist[i][j] + " ");
			}
			System.out.println("");
		}*/
		
		StringBuffer sb = new StringBuffer();
		String lineSeparator = System.getProperty("line.separator");
		
		for(int i = 1; i < n; i++){
			if(dist[genG.length()][i] <= countMutation){
				sb.append(i-1);
				sb.append(lineSeparator);
			}
		}
		System.out.print(sb.toString());
		
		
	}
}
