 static int[] Live_Die(int a[700][700])
 {
  int count,x,y,b[700][700];
  for( x=0; x<700 ; x++)
  {
   count =  0;
   for( y=0; y<700 ; y++)
   {
    if(a[x+1][y] == 1 && (x+1)<700) // next element in the row
     count++;
    if(a[x-1][y] == 1 && (x-1)>=0) // previous element in row
     count++;
    if(a[x][y+1] == 1 && (y+1)<700) // element above it
     count++;
    if(a[x][y-1] == 1 && (y-1)>=0) // element below it
     count++;
    if(a[x+1][y+1] == 1 && (x+1)<700 && (y+1)<700) // element to bottom right
     count++;
    if(a[x+1][y-1] == 1 && (x+1)<700 && (y-1)>=0) // element to bottom left
     count++;
    if(a[x-1][y+1] == 1 && (y+1)<700 && (x-1)>=0) // element top right 
     count++;
    if(a[x-1][y-1] == 1 && (y-1)>=0 && (x-1)>=0) // element top left
     count++; 
    if(count> 3 && a[x][y] == 1) // over population death
     b[x][y]=0;
    else if( count<4 && count>1 && a[x][y]== 1) // remains alive
     b[x][y]=1;
    else if(count<2 && a[x][y]==1) // death due to solitude
     b[x][y]=0;
    else if(count == 3 && a[x][y]==0) // population condition
     b[x][y]=1;
    else
     b[x][y]=0;
    }
   }
  return b;
 }
