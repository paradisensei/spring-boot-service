<form role="form" action="/zodiac" method="get">
  <fieldset>
    <legend>Узнайте свой знак зодиака</legend>
    <input title="Дата рождения" name="date" type="date">
    <input type="submit" value="Узнать">
  </fieldset>
</form>

<#if zodiac??>
  По знаку зодиака вы ${zodiac}
</#if>