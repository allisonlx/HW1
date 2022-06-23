import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Polynomial {

    ArrayList<Term> terms;

    public Polynomial(){
        terms = new ArrayList<Term>();
    }

    public Term getTerm(int index){
        return this.terms.get(index);
    }

    //public Term setTerm

    public int getNumTerms(){
        return this.terms.size();
    }


    public void addTerm(Term t){
        boolean duplicate = false;
        for (int i = 0; i < terms.size(); i++){
            if (terms.get(i).getExponent() == t.getExponent()){
                Term original = terms.get(i);
                terms.set(i, new Term(original.getCoefficient() + t.getCoefficient(), t.getExponent()));
                duplicate = true;
            }
        }
        if (!duplicate) {
            this.terms.add(t);
        }
        Collections.sort(this.terms, Comparator.comparing(Term::getExponent));
        Collections.reverse(this.terms);
    }

    @Override
    public String toString(){
        String output = "";
        if (this.terms.size() == 0){
            return "0";
        }
        Collections.sort(this.terms, Comparator.comparing(Term::getExponent));
        Collections.reverse(this.terms);
        String term1;
        if(terms.get(0).getCoefficient() < 0){
            output += this.terms.get(0).toString();
        }
        else {
            String t1 = terms.get(0).toString().substring(1);
            output += t1;
        }
        for (int i = 1; i < this.terms.size(); i++){
            output += this.terms.get(i).toString();
        }
        return output;
    }

    @Override
    public boolean equals(Object other){
        if (other == null || !(other instanceof Polynomial)){
            return false;
        }
        Polynomial that = (Polynomial)other;
        return this.terms.equals(that.terms);
    }

}
