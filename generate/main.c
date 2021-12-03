#include "magic.h"
#include <stdio.h>

int main () { int Aaa [ 3 ] ; int AAa = 0 ; _Bool aaA = 0; int aAa ; goto A ;
    //String "premier" ou "deuxième"
    A : ;
    char * aAaA = AAa ? "deuxième" : "premier" ;
    goto aa ;
    //Demande entrée nombre
    aa : ;
    printf ( "Entrez le %s nombre : " , aAaA ) ;
    goto AA ;
    //Demande entrée opérateur
    aaa : ;
    printf ( "Entrez l'opérateur (1=+,2=-,3=*,4=/) : " ) ;
    goto AA ;
    //Entrée utilisateur
    AA : ;
    scanf ( "%d" , & Aaa [ AAa ++ ] ) ;
    goto aaaa ;
    //Aiguillage inputs
    aaaa : ;
    if ( AAa == 3 ) goto AAA ; else if ( AAa == 1 ) goto aaa ;
    goto A ;
    //Fin inputs, début traitement
    AAA : ;
    if ( Aaa [ 1 ] == 3 ) goto AAAA ; else if ( Aaa [ 1 ] == 1 ) goto AAAAA ; else if ( Aaa [ 1 ] == 2 ) goto AAAAAA ; else if ( Aaa [ 1 ] == 4 ) goto AAAAAAA ;
    goto B ;
    //Multiplication
    AAAA : ;
    if ( Aaa [ 2 ] < 0 ) { aaA = 1 ; Aaa [ 2 ] = - Aaa [ 2 ] ; goto AAAA ; } else { aAa = Aaa [ 0 ] ; for ( int b = 1 ; b < Aaa [ 2 ] ; b ++ ) Aaa [ 0 ] += aAa ; }
    goto AAAAAAAAAA ;
    //Addition
    AAAAA : ;
    if ( Aaa [ 2 ] ) if ( Aaa [ 2 ] > 0 ) { Aaa [ 0 ] ++ ; Aaa [ 2 ] -- ; goto AAAAA ; } else { Aaa [ 2 ] = - Aaa [ 2 ] ; goto AAAAAA ; }
    goto AAAAAAAAAA;
    //Soustraction
    AAAAAA : ;
    if ( Aaa [ 2 ] ) if ( Aaa [ 2 ] > 0 ) { Aaa [ 0 ] -- ; Aaa [ 2 ] -- ; goto AAAAAA ; } else { Aaa [ 2 ] = - Aaa [ 2 ] ; goto AAAAA ; }
    goto AAAAAAAAAA;
    //Division
    AAAAAAA : ;
    if ( Aaa [ 2 ] < 0 ) { aaA = !aaA; Aaa [ 2 ] = - Aaa [ 2 ] ; goto AAAAAAA ; } if ( Aaa [ 0 ] < 0 ) { aaA = 1; Aaa [ 0 ] = - Aaa [ 0 ] ; goto AAAAAAA ; } if ( Aaa [ 2 ] == 0 ) goto BB ; for ( aAa = 0 ; Aaa [ 0 ] >= Aaa [ 2 ] ; aAa ++ ) Aaa [ 0 ] -= Aaa [ 2 ] ; if ( aaA ) Aaa [ 0 ] *= -1 ; printf ( "(Reste = %d) " , Aaa [ 0 ] ) ; Aaa [ 0 ] = aAa ;
    goto AAAAAAAAAA;
    //Affichage résultat
    AAAAAAAAAA : ;
    if ( aaA ) Aaa [ 0 ] *= - 1 ; printf ( "Résultat = %d\n" , Aaa [ 0 ] ) ;
    return 0;
    // Operateur inconnu
    B : ;
    printf ( "Opérateur inconnu\n" ) ;
    return 1 ;
    //Division par 0
    BB : ;
    printf ( "Division par zéro\n" ) ;
    return 1 ;
}