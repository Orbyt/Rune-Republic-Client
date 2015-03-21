import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ShortKeyModel extends AbstractTableModel{

	private List<Entry> keys;
	public ShortKeyModel(List<Entry> s){
		this.keys = s;
	}
	
	public String getColumnName(int index){
		switch(index){
		case 0:
			return "ShortKey";
		case 1:
			return "Replacement Key";
		}
			return "null";
		
	}
		
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return keys.size();
	}

	@Override
	public Object getValueAt(int row, int index) {
		Entry in = keys.get(row);
		switch(index) {
		case 0:
			return in.getKey();
		case 1:
			return in.getValue();
		}
			return null;
		
	}
}
