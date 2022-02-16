import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.ArrayList;
import java.util.List;

public class VillageData 
{
	public int x, y;
	String Hundred;
	String Name;
	
	Integer VillagerHouses;
	Integer SmallHolderHouses;
	Integer SlaveHouses;
	
	List<House> Houses = new ArrayList<House>();
	
	public VillageData()
	{
		//Default test constructor
		Name = "Test";
		VillagerHouses = 1;
		x = 0;
		y = 0;
	}
	public VillageData(float Lat, float Long, String name,Main app)
	{
		y = LatToCoord(Lat);
		x = LongToCoord(Long);
		Name = name;
		Houses.add(new House(app,x,y));
	}
	
	
	private static int LatToCoord(float Lat)
	{
		System.out.println(Lat);
		Lat = Lat +3.109f;
		System.out.println(Lat);
		Lat = (float) ( Lat/(1.28*Math.pow(10,-5)));
		System.out.println(Lat);
		return (int) Lat;
	}
	
	private static int LongToCoord(float Long)
	{

		
	
		Long = Long -50.74f;
		
		Long = (float) (Long/(1.28*Math.pow(10,-5)));
		
		return -(int)Long;
	}
	
	
	public void CollectVillageData(Document doc)
	{
		//Firstly collect the data about the number of houses
		try
		{
			
		
		String[] Households = doc.body().getElementById("people").nextSibling().toString().split(" ");
		int CurrentIdx=1;
		if(CurrentIdx<Households.length)
		{
			if(Households[CurrentIdx]=="villagers")
			{
				VillagerHouses = Integer.parseInt(Households[CurrentIdx-1]);
				CurrentIdx+=2;
			}
		}
		if(CurrentIdx<Households.length)
		{
			if(Households[CurrentIdx]=="smallholders")
			{
				SmallHolderHouses = Integer.parseInt(Households[CurrentIdx-1]);
				CurrentIdx+=2;
			}
		}
		if(CurrentIdx<Households.length)
		{
			if(Households[CurrentIdx]=="slave")
			{
				SlaveHouses = Integer.parseInt(Households[CurrentIdx-1]);
				CurrentIdx+=2;
			}
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}
