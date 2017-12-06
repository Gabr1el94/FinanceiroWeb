/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    var $ = jQuery;
    $(document).ready(function() {
        $("input[id*='dataNascimento']").mask('99/99/9999');
         $("input[id*='emissao']").mask('99/99/9999');
    });

});

