
		public void run() {
			// TODO Auto-generated method stub
			 int count,x,y;
				 int [][]b=new int[116][78];
				 for( x=5; x<115 ; x++)
				  {
				   count =  0;
				   for( y=5; y<75 ; y++)
				   {
					
				    if(cells[x+1][y] == 1 && (x+1)<115) // next element in the row
				     count++;
				    if(cells[x-1][y] == 1 && (x-1)>5) // previous element in row
				     count++;
				    if(cells[x][y+1] == 1 && (y+1)<75) // element above it
				     count++;
				    if(cells[x][y-1] == 1 && (y-1)>5) // element below it
				     count++;
				    if(cells[x+1][y+1] == 1 && (x+1)<115 && (y+1)<75) // element to bottom right
				     count++;
				    if(cells[x+1][y-1] == 1 && (x+1)<115 && (y+1)>5) // element to bottom left
				     count++;
				    if(cells[x-1][y+1] == 1 && (x-1)>5 && (y+1)<115) // element top right 
				     count++;
				    if(cells[x-1][y-1] == 1 && (x-1)>5 && (y-1)>5) // element top left
				     count++; 
				    if(cells[x][y] == 1)
				     {
				    	if(count>=4) // over population death			
				    		b[x][y]=0;
				    	else if( count>=2) // remains alive
				    		b[x][y]=1;
				    	else // death due to solitude
				    		b[x][y]=0;
				     }
				    else if(cells[x][y]==0)
				    	if(count == 3) // population condition
				    		b[x][y]=1;
				    else
				     b[x][y]=0;
				    }
				   }
				 for( x=5; x<115 ; x++)
				  {
				   for( y=5; y<75 ; y++)
				   {
					   System.out.print(b[x][y]+" ");
				   }
				   System.out.println("");
				  }
		}
}
				
