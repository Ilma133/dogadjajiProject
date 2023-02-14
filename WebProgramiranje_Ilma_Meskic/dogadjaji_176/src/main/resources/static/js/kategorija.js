
 $('document').ready(function(){
      $('.table .btn-primary').on('click', function(event){
      event.preventDefault();

      var href=$(this).attr('href');

      $.get(href, function(kategorija, status){
        $('#idEdit').val(kategorija.id);
        $('#NameEdit').val(kategorija.name);
        $('#PhotoEdit').val(kategorija.icon);
      });

      $('#editModal').modal();
      });
      });