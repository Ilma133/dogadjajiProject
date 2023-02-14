
$('document').ready(function(){
      $('.table .btn-primary').on('click', function(event){
      event.preventDefault();

      var href=$(this).attr('href');

      $.get(href, function(dogadjaj, status){
        console.log(dogadjaj);
        $('#idEdit').val(dogadjaj.id);
        $('#NameEdit').val(dogadjaj.dogadjajname);
        $('#DateEdit').val(dogadjaj.datum);
        $('#DescriptionEdit').val(dogadjaj.description);
        $('#PhotoEdit').val(dogadjaj.photoURL);
        $('#LokacijaEdit').val(dogadjaj.lokacija.name);
        $('#KategorijaEdit').val(dogadjaj.kategorija.name);
      });

      $('#editModal').modal();
      });
      });