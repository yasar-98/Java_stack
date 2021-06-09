public class StringManipulator {
    public String trimAndConcat(String x,String y) {
        return x.trim().concat(y.trim());
    }

    public int getIndexOrNull(String z, char h) {
        return z.indexOf(h);
    }
    public Integer getIndexOrNull(String v, String c) {
        return v.indexOf(c);
    }
	public String concatSubstring(String u, int i, int o, String p){
        String t=u.substring(i,o);
		return t.concat(p);
    }

}