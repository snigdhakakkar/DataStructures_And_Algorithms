package recursion_and_dynamic_programming.Robot_in_a_grid;

public class point {
	
	public int row, column;
	public point(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
	
	@Override
	 public int hashCode() {
        return this.toString().hashCode();
    }
	
	@Override
	public boolean equals(Object o) {
		if ((o instanceof point) && (((point) o).row == this.row) && 
				(((point) o).column == this.column)) {
            return true;
        } else {
            return false;
        }
	}

}
