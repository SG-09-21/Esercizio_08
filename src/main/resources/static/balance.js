$(document).ready(function()
{
	//assegnazione evento click al bottone id="elimina"
	//$('#elimina').click(function(){
	//	confirm("ciao")
	//})
	
	
	$('.button-elimina').each(function(){
		$(this).click(function(){
			confirm($(this).val())
		})
	})
	
	// finestra di dialogo personalizzata
	window.confirm = function(dati){
		// recupero e separazione dati
		let datiPassati = dati.split("@");
		// costruzione popup di conferma
		let popupConferma = $(
			   `<div class="popup-cancellazione">
				<h2 style="font-size: 20px;font-weight: bold;margin-bottom: 10px;">Conferma cancellazione</h2>
				<p style="font-size: 18px;margin-bottom: 20px;">Sei sicuro di voler cancellare ${datiPassati[1]}?</p>
				<button class="button-abbandona">Abbandona</button>
				&emsp;
				<button class="button-conferma">Conferma</button>
				</div>`);
		// aggiunta popup al body
		$('body').append(popupConferma);
    	popupConferma.fadeIn();
		// evento al click del button abbandona
    	$('.button-abbandona').click(function() {
      		popupConferma.fadeOut();
    	})
		// evento al click del button conferma
    	$('.button-conferma').click(function() {
      		popupConferma.fadeOut();
            invioRichiesta(datiPassati[0])
		})
	}
	
	//funzione per inviare richiesta asicrona al controller java
	
	function invioRichiesta(idProdotto){
		$.get(
			'/cancella',
			{id:idProdotto},
			function(response){
			console.log(response)
			if(response === "cancellato")
			location.href = "/"
			}
		)
	}
})