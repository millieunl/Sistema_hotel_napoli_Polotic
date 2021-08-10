$('document').ready(function(){
	$('.data-table').DataTable({
		scrollCollapse: true,
		autoWidth: false,
		responsive: true,
		columnDefs: [{
			targets: "datatable-nosort",
			orderable: false,
		}],
		"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
		"language": {
			"info": "_START_-_END_ of _TOTAL_ entries",
			searchPlaceholder: "Search",
			paginate: {
				next: '<i class="ion-chevron-right"></i>',
				previous: '<i class="ion-chevron-left"></i>'  
			}
		},
	});


	//settings para la tabla que selecciona una fila
	var table = $('#mitabla').DataTable();
    	$('#mitabla').on( 'click', 'tr', function () {
		if ( $(this).hasClass('selected') ) {
		    $(this).removeClass('selected');
		}
		else {
		    table.$('tr.selected').removeClass('selected');
		    $(this).addClass('selected');
		}
   	} );
        
        
        $(function () {
        $('#si').on('click', function (e) {
            $('#borrar').submit();
        });
    });
 
});
