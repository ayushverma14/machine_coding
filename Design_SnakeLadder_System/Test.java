package Design_SnakeLadder_System;
import java.io.*;
//Test Class for testing the playground
public class Test {
    public static void main(String args[]) throws IOException
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
Board bd=new Board();
int sn1=Integer.parseInt(br.readLine());
for(int i=0;i<sn1;i++)
{
    String arr[]=br.readLine().split(" ");
    int iniPos=Integer.parseInt(arr[0]);
    int finalPos=Integer.parseInt(arr[1]);
    bd.snakes.put(iniPos,finalPos);

}
int ld1=Integer.parseInt(br.readLine());
for(int i=0;i<ld1;i++)
{
    String arr[]=br.readLine().split(" ");
    int iniPos=Integer.parseInt(arr[0]);
    int finalPos=Integer.parseInt(arr[1]);
    bd.ladders.put(iniPos,finalPos);
    
}
int pl1=Integer.parseInt(br.readLine());
for(int i=0;i<pl1;i++)
{
    String pl=br.readLine();
    bd.players.add(pl);
    bd.positions.add(0);
    
}
int dice=0;
int pos=0;

while(true)
{

    dice=(int)((Math.random()*10)%6)+1;
    boolean res=bd.moves(pos,dice);
    if(res)
    {System.out.println("Player "+bd.players.get(pos)+" wins");
    break;}
    pos=(pos+1)%pl1;
    

}

}

}
