#include "magic.h"
#include <stdio.h>

int main () { int input [ 3 ] ; int count = 0 ; _Bool flipSign = 0; int aAa ; goto A ;
    //String "premier" ou "deuxième"
    A : ;
    char * pos = count ? "deuxième" : "premier" ;
    goto aa ;
    //Demande entrée nombre
    aa : ;
    printf ( "Entrez le %s nombre : " , pos ) ;
    goto AA ;
    //Demande entrée opérateur
    aaa : ;
    printf ( "Entrez l'opérateur (1=+,2=-,3=*,4=/) : " ) ;
    goto AA ;
    //Entrée utilisateur
    AA : ;
    scanf ( "%d" , & input [ count ++ ] ) ;
    goto aaaa ;
    //Aiguillage inputs
    aaaa : ;
    if ( count == 3 ) goto AAA ; else if ( count == 1 ) goto aaa ;
    goto A ;
    //Fin inputs, début traitement
    AAA : ;
    if ( input [ 1 ] == 3 ) goto AAAA ; else if ( input [ 1 ] == 1 ) goto AAAAA ; else if ( input [ 1 ] == 2 ) goto AAAAAA ; else if ( input [ 1 ] == 4 ) goto AAAAAAA ;
    goto B ;
    //Multiplication
    AAAA : ;
    if ( input [ 2 ] < 0 ) { flipSign = 1 ; input [ 2 ] = - input [ 2 ] ; goto AAAA ; } else { aAa = input [ 0 ] ; for ( int b = 1 ; b < input [ 2 ] ; b ++ ) input [ 0 ] += aAa ; }
    goto AAAAAAAAAA ;
    //Addition
    AAAAA : ;
    if ( input [ 2 ] ) if ( input [ 2 ] > 0 ) { input [ 0 ] ++ ; input [ 2 ] -- ; goto AAAAA ; } else { input [ 2 ] = - input [ 2 ] ; goto AAAAAA ; }
    goto AAAAAAAAAA;
    //Soustraction
    AAAAAA : ;
    if ( input [ 2 ] ) if ( input [ 2 ] > 0 ) { input [ 0 ] -- ; input [ 2 ] -- ; goto AAAAAA ; } else { input [ 2 ] = - input [ 2 ] ; goto AAAAA ; }
    goto AAAAAAAAAA;
    //Division
    AAAAAAA : ;
    if ( input [ 2 ] < 0 ) { flipSign = !flipSign; input [ 2 ] = - input [ 2 ] ; goto AAAAAAA ; } if ( input [ 0 ] < 0 ) { flipSign = 1; input [ 0 ] = - input [ 0 ] ; goto AAAAAAA ; } if ( input [ 2 ] == 0 ) goto BB ; for ( aAa = 0 ; input [ 0 ] >= input [ 2 ] ; aAa ++ ) input [ 0 ] -= input [ 2 ] ; if ( flipSign ) input [ 0 ] *= -1 ; printf ( "(Reste = %d) " , input [ 0 ]) ; input [ 0 ] = aAa ;
    goto AAAAAAAAAA;
    //Affichage résultat
    AAAAAAAAAA : ;
    if ( flipSign ) input [ 0 ] *= - 1 ; printf ( "Résultat = %d\n" , input [ 0 ] ) ;
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