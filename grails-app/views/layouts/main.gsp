<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Baby Trader" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
    </head>
    <body>
        <div class="nav"><a href="${createLink(action:'create',controller:'sittingSession')}">Request A Sitter</a></div>
        <g:layoutBody />
    </body>
</html>