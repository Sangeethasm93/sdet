package Activity1a

class Activity1a 
{
	static void main(def args)
	{
		def inputList = [11, 2, 19, 5, "Mango", "Apple", "Watermelon"]
		println inputList
		
		def integerList = inputList.minus(["Mango", "Apple", "Watermelon"])
		println integerList
		
		def stringList = inputList.minus([11, 2, 19, 5])
		println stringList
		
		
	}
}
