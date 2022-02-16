import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;




public class Scrapper
{
	public static List<VillageData> GetVillagesInRadius(float x, float y, int dist,Main app)
	{
		
		
		
		
		return null;
	}
	
	public static void GetLandscapeTile(int x, int y,Main app)
	{
		final String url = "https://tile.nextzen.org/tilezen/terrain/v1/512/terrarium/14/8050/5503.png?api_key=wHea7mn6Sc6ihgApZopZFQ";
		try {
		Document document = Jsoup.connect(url).ignoreContentType(true).get();
		System.out.println(document.html());
		Elements images = document.select("img"); 
		System.out.println(images.size());
        
		downloadImage("https://tile.nextzen.org/tilezen/terrain/v1/512/terrarium/14/8050/5503.png?api_key=wHea7mn6Sc6ihgApZopZFQ");
        //downloadImage(imageElement.attr("abs:src"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
 
    }
    
    private static void downloadImage(String strImageURL){
        
        //get file name from image path
        String strImageName = 
                strImageURL.substring( strImageURL.lastIndexOf("/") + 1 );
        
        
        
        try {
            
            //open the stream from URL
            URL urlImage = new URL("https://tile.nextzen.org/tilezen/terrain/v1/512/terrarium/14/8050/5503.png?api_key=wHea7mn6Sc6ihgApZopZFQ");
            InputStream in = urlImage.openStream();
            System.out.println(in);
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
	

}