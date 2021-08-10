document.addEventListener('readystatechange', event => { 

//fix para  la tabla con checkboxes
   html = `
   <label>
      Mostrar 
      	<select name="datatables_length" aria-controls="mitabla_length" class="custom-select custom-select-sm form-control form-control-sm">
         	<option value="10">10</option>
		<option value="25">25</option>
		<option value="50">50</option>
		<option value="-1">All</option>
	</select>
	Entradas
     </label>
`;

// When window loaded ( external resources are loaded too- `css`,`src`, etc...) 
    if (event.target.readyState === "complete") {
      document.getElementById("mitabla_filter").style.display = "none";     
      document.getElementById("mitabla_length").innerHTML = html;
    }
    
/*
	//fix para  la tabla con checkboxes
      html = `
   <label>
      Mostrar 
      	<select name="DataTables_Table_0_length" aria-controls="DataTables_Table_0" class="custom-select custom-select-sm form-control form-control-sm">
         	<option value="10">10</option>
		<option value="25">25</option>
		<option value="50">50</option>
		<option value="-1">All</option>
	</select>
	Entradas
     </label>
`;

    // When window loaded ( external resources are loaded too- `css`,`src`, etc...) 
    if (event.target.readyState === "complete") {
      document.getElementById("DataTables_Table_0_filter").style.display = "none";     
      document.getElementById("DataTables_Table_0_length").innerHTML = html;
     
   
    }
   
    
     //fix para la tabla seleccionar una columna
      html2 = `
   <label>
      Mostrar 
      	<select name="mitabla_length" aria-controls="DataTables_Table_0" class="custom-select custom-select-sm form-control form-control-sm">
         	<option value="10">10</option>
		<option value="25">25</option>
		<option value="50">50</option>
		<option value="-1">All</option>
	</select>
	Entradas
     </label>
`;

    // When window loaded ( external resources are loaded too- `css`,`src`, etc...) 
    if (event.target.readyState === "complete") {
      document.getElementById("mitabla_filter").style.display = "none";     
      document.getElementById("mitabla_length").innerHTML = html2;
     
   
    }
    */
    
    
    
});
