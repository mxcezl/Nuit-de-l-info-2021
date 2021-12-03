import React, { Component } from 'react';
import "../styles/pages/sauveteur.css"

class Sauveteur extends Component {
    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            items: []
        };
    }

    componentDidMount() {
        fetch("http://zolnieruck.alwaysdata.net/admin/nom?nom=zol")
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        isLoaded: true,
                        items: result
                    });
                },
                // Remarque : il est important de traiter les erreurs ici
                // au lieu d'utiliser un bloc catch(), pour ne pas passer à la trappe
                // des exceptions provenant de réels bugs du composant.
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            )
    }

    render() {
        const { error, isLoaded, items } = this.state;

        if (error) {
            return <div>Erreur : {error.message}</div>;
        } else if (!isLoaded) {
            return <div>Chargement…</div>;
        } else {
            let item = items[0]
            return (
                <div id="page-container">
                    <div id="info-sauveteur">
                        <div id="info-gauche">
                            <div id="page-titre">
                                <div id="identite">
                                    <div id="nom">{item.nom}</div>
                                    <div id="prenom">{item.prenom}</div>
                                </div>
                                <div id="profession">{item.profession}</div>
                            </div>
                            <div class="bloc_text">
                                <div class="titre">Décoration</div>
                                {
                                    () => {
                                        for (let decoration in item.decoration) {
                                            <p>{decoration}</p>
                                        }
                                    }
                                }
                            </div>

                            <div class="bloc_text">
                                <div class="titre">Généalogie</div>
                                {
                                    () => {
                                        for (let genealogie in item.genealogie) {
                                            <p>{genealogie}</p>
                                        }
                                    }
                                }
                            </div>
                        </div>
                        <div id="info-droite">
                            <img id="image_profil"
                                src={item.photoProfil}>
                            </img>
                            <div id="dates">
                                <div class="date">
                                    Naissance
                                    <div class="date-format">{item.naissance.date}</div>
                                    {item.naissance.ville}
                                </div>
                                <div class="date">
                                    Décès
                                    <div class="date-format">{item.deces.date}</div>
                                    {item.deces.ville}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="articles">
                        {
                            () => {
                                for (let article in item.articles) {
                                    <div class="bloc_text">
                                        <div class="titre">article.titre</div>
                                        <p class="contenu">article.contenu</p>
                                    </div>
                                }
                            }
                        }
                    </div>
                </div>

            );
        }
    }
}

export default Sauveteur;