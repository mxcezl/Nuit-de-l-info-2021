import React from 'react';
import "../styles/pages/sauveteur.css"

function Sauveteur(props) {
    return (
        <div id="page-container">
            <div id="info-sauveteur">
                <div id="info-gauche">
                    <div id="page-titre">
                        <div id="identite">
                            <div id="nom">MOREL</div>
                            <div id="prenom">Jacques-Benjamin</div>
                        </div>
                        <div id="profession">Député, philantrope, fondateur de la société humaine</div>
                    </div>
                    <div class="bloc_text">
                        <div class="titre">Décoration</div>
                        <div>Chevalier de la Légion d’Honneur |30/05/1837</div>
                        <div>Port de la décoration autorisé par décret impérialr | 06/1854</div>
                        <div>Médaille d’or à l’effigie de la Reine Victoria | -</div>
                    </div>

                    <div class="bloc_text">
                        <div class="titre">Généalogie</div>
                        <div>Parent : Benjamin MOREL | 08/09/1751 - 02/11/1813 </div>
                        <div> Magdeleine Charlotte DUFAUX | 18/05/1751 - 08/09/1815 </div>
                        <div>Couple : Jacqueline Eleonore FILLIETAZ | 23/02/1789 - 11/07/1854 </div>
                    </div>
                </div>
                <div id="info-droite">
                    <img id="image_profil"
                        src="https://sauveteurdudunkerquois.fr/wp-content/uploads/2021/09/Morel-Benjamin-Portrait.jpg">
                    </img>
                    <div id="dates">
                        <div class="date">
                            Naissance
                            <div class="date-format">26 MAR. 1781</div>
                            Dunkerque
                        </div>
                        <div class="date">
                            Décès
                            <div class="date-format">24 AOU. 1860</div>
                            Dunkerque
                        </div>

                    </div>
                </div>
            </div>
            <div id="articles">
                <div class="bloc_text">
                    <div class="titre">Citation</div>
                    <p class="contenu">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facilis, perspiciatis,
                        in cum itaque animi
                        recusandae porro incidunt culpa reiciendis quisquam dignissimos, doloremque suscipit deserunt
                        ipsa!
                        Illum ab fuga neque deserunt.</p>
                </div>
                <div class="bloc_text">
                    <div class="titre">Vie professionnelle</div>
                    <p class="contenu">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facilis, perspiciatis,
                        in cum itaque animi
                        recusandae porro incidunt culpa reiciendis quisquam dignissimos, doloremque suscipit deserunt
                        ipsa!
                        Illum ab fuga neque deserunt.</p>
                </div>
            </div>
        </div>

    );
}

export default Sauveteur;