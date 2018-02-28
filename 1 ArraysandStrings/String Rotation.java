public boolean isRotation(String sl, String s2) 
{
 int len = sl.length();
 if (len == s2.length() && len > 0) 
 return isSubstring(sl+sl, s2);
 return false;
}
