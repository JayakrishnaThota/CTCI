
public class missingnumber {int findMissing(ArrayList<Bitinteger> array) {
     return findMissing(array, 0);
 }

 int findMissing(ArrayList<Bitinteger> input, int column) {
 if (column >= Bitinteger.INTEGER_SIZE) {//We're done!
 return 0;

}
Arraylist<Bitlnteger> oneBits = new Arraylist<Bitlnteger>(input.size()/2);
 Arraylist<Bitlnteger> zeroBits = new ArrayList<Bitlnteger>(input.size()/2);

 for (Bitinteger t : input) {
 if (t.fetch(column) == 0) {
 zeroBits.add(t);

} else {
 oneBits.add(t);

}

}
 if (zeroBits.size() <= oneBits.size()) {
 int v = findMissing(zeroBits, column+ 1);
 return (v << 1) | 0;

} else {
 int v = findMissing(oneBits, column+ 1);
 return (v << 1) | 1;

}

}
}
