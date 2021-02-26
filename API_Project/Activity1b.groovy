package GroovyProject1

class Activity1b 
{
public static void main(def args)
	{
		File file = new File("src/resources/input.txt")
		file.createNewFile();
		
		//Write text to input.txt
		file.write("A quick brown Fox jumped over the lazy Cow\n")
		file.append("John Jimbo jingeled happily ever after\n")
		file.append("Th1\$ 1\$ v3ry c0nfus1ng")
		
		file.eachLine { 
			if(it=~ /Cow$/)	{
				println it
			}		
			if(it=~ /^J/) {
				println it
			}
			if(it=~ /\d{2}/) {
				println it
			}
			
			
		}
		def match1= (file.text=~/\S+er/).findAll()
				println match1
		def match2= file.text=~/\S*\d\W/
		        println match2.findAll()
				println match2
	}
}
