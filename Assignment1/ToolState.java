package Assignment1;

public class ToolState {

	private final static ToolState toolState = new ToolState();
	private Tools tool = Tools.SELECT;
	private int option;

	public Tools getTool() {
		return tool;
	}

	public void setTool(Tools tool) {
		this.tool = tool;
	}

	public final static ToolState getState() {
		return toolState;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

}