package Tweet;

import java.io.*;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.Status;
import twitter4j.TwitterException;

public class tweet {
    public static void main(String[] args) throws IOException, TwitterException {
    	String tweet = "";
    	try{
    		tweet += "�y�^��I���z "+args[1]+" "+args[0]+" ["+args[2]+"]\n";
    	} catch(ArrayIndexOutOfBoundsException e){
    		System.out.println("�������������ݒ肳��Ă��܂���B");
    	}
    	try{
    		File logfile = new File("tvrock.log2");
    		FileReader filereader = new FileReader (logfile);
    		BufferedReader br = new BufferedReader(filereader);
    		String str = br.readLine();

    		while(str!=null){
    			str = br.readLine();
    			try{
    				if(str.indexOf(args[0]) != -1 && str.indexOf("�^��I�� Card=OK") != -1){
    					try{
    						String[] log = str.split(",");
    						tweet += "["+ log[1].trim() +", "+ log[2].trim() +", "+ log[4].trim() +", "+ log[5].trim() +"]";
    						break;
    					} catch(ArrayIndexOutOfBoundsException e){
    						System.out.println("���O�f�[�^�ɊY�����ڂ͂���܂���");
    						break;
    					}
    				}
    			}catch(NullPointerException e){
    				System.out.println("���O�f�[�^�ɊY�����ڂ͂���܂���B");
				break;
    			}
    		}
    		br.close();
    	}catch(FileNotFoundException e){
    		System.out.println(e);
    	}catch(IOException e){
    		System.out.println(e);
    	}
    	
        Twitter twitter = new TwitterFactory().getInstance();
        Status status = twitter.updateStatus(tweet);

    	System.out.println(tweet);
    }

}
