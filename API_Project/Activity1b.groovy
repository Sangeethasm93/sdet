package Activity_1b

class Activity_1b 
{
	static void main  (def arg)
	{
		File filer = new File("src/API_Project_Activity_1a/ToBeBombarded.txt")
		filer.createNewFile()
		
		filer.write("A quick brown Fox jumped over the lazy Cow\n")
		filer.append("John Jimbo jingeled happily ever after\n")
		filer.append("Th1\$ 1\$ v3ry c0nfus1ng\n")
		filer.append("This is a line with 2 numbers like 12")
		
		filer.eachLine 
		{ 
			
			if(it =~ /Cow$/)
			{
				println "Here inside cow"
			}
			
			if(it =~ /^J/)
			{
				println it
			}
			
			if(it =~ /\d{2}/)
			{
				println it
			}
		
		}
		def matcher1 = filer.text =~ /\S+er/		
		println matcher1.findAll()
		
		def matcher2 = filer.text =~ /\S*\d\W/
		println matcher2.findAll()
		
		
		
		
			
	}
}
