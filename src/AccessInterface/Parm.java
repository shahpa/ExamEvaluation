package AccessInterface;

public class Parm<parmT>
{
	private TypeID type;
	private parmT parm;
	
	public void setType(TypeID type)
	{
		this.type = type;
	}
	
	public TypeID getType()
	{
		return type;
	}
	
	public void setParm(parmT parm)
	{
		this.parm = parm;
	}
	
	public parmT getParm()
	{
		return parm;
	}
}
