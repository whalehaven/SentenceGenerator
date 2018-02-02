	public class Noun extends Word
	{
		
		//constructor
		public Noun( String content )
		{
			super( content );
		}
		
		//member methods
		public void makePlural()
		{
			this.content += "s";
		}
		
		
		public boolean isPlural()
		{
			String pluralValue = this.getContent().substring( this.getContent().length() - 1, this.getContent().length());
			String constantValue = "s";
			
			if ( pluralValue.equals( constantValue ))
				return true;
				
			else
				return false;
		}
			
		public String getContent()
		{
			return this.content;
		}
		
		public String getInitialLetter()
		{
			return this.content.substring( 0, 1 );
		}
		
		
		
	}
	
