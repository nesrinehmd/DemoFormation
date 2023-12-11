package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsTest {

    public static void main(String[] args) {

        Personne2 PTestEq1 = new Personne2("NomPEQ1", "PrenomPEQ1") ;
        Personne2 PTestEq2 = new Personne2("NomPEQ1", "PrenomPEQ1") ;
        Personne2 PTestEq3 = PTestEq1 ;

        if (PTestEq1.equals(PTestEq2) ) {
            System.out.println("Resultat de PTestEq1.equals(PTestEq2) : Yes");
        }else {
            System.out.println("Resultat de PTestEq1.equals(PTestEq2) : No");
        }

        if (PTestEq1.equals(PTestEq3) ) {
            System.out.println("Resultat de PTestEq1.equals(PTestEq3) : Yes");
        }else {
            System.out.println("Resultat de PTestEq1.equals(PTestEq3) : No");
        }

        int HashCodePEQ1 = PTestEq1.hashCode() ;
        System.out.println("Le HashCode de PersonneEquals1 est: " +HashCodePEQ1 );


        List<Personne> P = Arrays.asList(
                new Personne( "NomP1", "PrenomP1", Arrays.asList("PrenomP12" ,"PrenomP13") ,  20 ) ,
                new Personne( "NomP2", "PrenomP2", Arrays.asList("PrenomP22" ) , 25 ) ,
                new Personne( "NomP3", "PrenomP3", Arrays.asList("PrenomP32" , "PrenomP33" , "PrenomP34" ) ,30 ) ,
                new Personne( "NomP4", "PrenomP4", Arrays.asList("PrenomP42" ,"PrenomP43") ,35 ) ,
                new Personne( "NomP5", "PrenomP5", Arrays.asList("" ) ,40 )
        );
        if (P.stream().anyMatch(Personne -> Personne.getAge() >= 30) )
            System.out.println("C'est une personne qui a un age supérieur à 30 ans");

        List<Personne> P2 = P.stream().filter(Personne -> Personne.getAge() <= 30 ).collect(Collectors.toList()) ;

        P2.forEach(Personne -> System.out.println(Personne.getNom() + ' ' + Personne.getPrenom()));

        List<Integer> AgePersonneSup30 =  P.stream().filter(Personne -> Personne.getAge() >= 30 ).map(Personne -> Personne.getAge()).collect(Collectors.toList()) ;
        System.out.println("Liste Age: "+ AgePersonneSup30 );

        List<String> DeuxiemePrenomPInf30 =  P.stream().filter(Personne -> Personne.getAge() <= 30 ).flatMap(Personne -> Personne.getDeuxiemePrenom().stream()).collect(Collectors.toList()) ;
        System.out.println("Liste Deuxiéme prénom des personnes inf 30: "+ DeuxiemePrenomPInf30 );

    }

    @Data
    @AllArgsConstructor
    public static class Personne {
           public String Nom ;
           public String Prenom ;
           public int Age ;
           List<String> DeuxiemePrenom ;

           public Personne (String Nom, String Prenom, List<String> DeuxiemePrenom , int Age ){
                this.Nom    = Nom ;
                this.Prenom = Prenom ;
                this.Age    = Age ;
                this.DeuxiemePrenom = DeuxiemePrenom ;
           }



 /*       public String getNom(){
            return Nom ;
        }

        public void setNom (String Nom){
            this.Nom = Nom ;
        }

        public String getPrenom(){
            return Prenom ;
        }

        public void setPrenom (String Prenom){
            this.Prenom = Prenom ;
        }

        public List<String> getDeuxiemePrenom(){
            return DeuxiemePrenom ;
        }

        public void setDeuxiemePrenom (List<String> DeuxiemePrenom){
            this.DeuxiemePrenom = DeuxiemePrenom;
        }

        public int getAge(){
            return Age;
        }

        public void setAge (int Age){
            this.Age = Age ;
        }

        */

    }


    @Data
    @AllArgsConstructor
    public static class Personne2 {
        public String Nom ;
        public String Prenom ;
       /*
        public Personne2 (String Nom, String Prenom){
            this.Nom    = Nom ;
            this.Prenom = Prenom ;
        }
        */


       /*
        public String getNom(){
            return Nom ;
        }

        public void setNom (String Nom){
            this.Nom = Nom ;
        }

        public String getPrenom(){
            return Prenom ;
        }

        public void setPrenom (String Prenom){
            this.Prenom = Prenom ;
        }
        */


    }
}
