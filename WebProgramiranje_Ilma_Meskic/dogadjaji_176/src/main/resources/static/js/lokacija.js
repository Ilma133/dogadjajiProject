
      $('document').ready(function(){
      $('.table .btn-primary').on('click', function(event){
      event.preventDefault();

      var href=$(this).attr('href');

      $.get(href, function(lokacija, status){
        $('#idEdit').val(lokacija.id);
        $('#NameEdit').val(lokacija.name);
        $('#DescriptionEdit').val(lokacija.description);
        $('#PhotoEdit').val(lokacija.photoURL);
      });

      $('#editModal').modal();
      });
      });