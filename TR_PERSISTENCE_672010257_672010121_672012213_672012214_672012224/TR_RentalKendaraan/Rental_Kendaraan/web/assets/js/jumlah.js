
// Quick links functions
function QuickHandler(what){
 var URL = what.options[what.selectedIndex].value;
 if (URL == 0) {return;}
 //if (URL == 1) {
 //  URL = "http://www.oanda.com/convert/classic?user=onlineconversion&lang=en";
 //} else {
   URL = "http://www.onlineconversion.com/" + URL;
 //}
window.location.href = URL;
}

function WriteQuickLinks(){
document.write('    <form name="Qform">' + "\n");
document.write('      <p><h2>Quick Links:</h2>' + "\n");
document.write('      <select size="1" name="QList" OnChange="javascript:QuickHandler(document.Qform.QList);">' + "\n");
document.write('        <option selected value="0">Select One...&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>' + "\n");
document.write('        <option value="0">----------</option>' + "\n");
document.write('        <option value="index.htm">Home</option>' + "\n");
document.write('        <option value="search/search.cgi">Search</option>' + "\n");
document.write('        <option value="forum/">Forums</option>' + "\n");
document.write('        <option value="faq.htm">FAQ</option>' + "\n");
document.write('        <option value="0">----------</option>' + "\n");
document.write('        <option value="acceleration.htm">Acceleration</option>' + "\n");
document.write('        <option value="angles.htm">Angles</option>' + "\n");
document.write('        <option value="area.htm">Area</option>' + "\n");
document.write('        <option value="astronomical.htm">Astronomical</option>' + "\n");
document.write('        <option value="automotive.htm">Automotive</option>' + "\n");
document.write('        <option value="electric_capacitance.htm">Capacitance</option>' + "\n");
document.write('        <option value="clothing.htm">Clothing</option>' + "\n");
document.write('        <option value="computer.htm">Computers</option>' + "\n");
document.write('        <option value="cooking.htm">Cooking</option>' + "\n");
document.write('        <option value="currency_conversion.htm">Currency</option>' + "\n");
document.write('        <option value="date_time.htm">Date/Time</option>' + "\n");
document.write('        <option value="density.htm">Density</option>' + "\n");
document.write('        <option value="length.htm">Distance</option>' + "\n");
document.write('        <option value="computer.htm">Electronics</option>' + "\n");
document.write('        <option value="energy.htm">Energy</option>' + "\n");
document.write('        <option value="finance.htm">Finance</option>' + "\n");
document.write('        <option value="flow_rate.htm">Flow Rate</option>' + "\n");
document.write('        <option value="force.htm">Force</option>' + "\n");
document.write('        <option value="frequency.htm">Frequency</option>' + "\n");
document.write('        <option value="funstuff.htm">Fun Stuff</option>' + "\n");
document.write('        <option value="html.htm">HTML</option>' + "\n");
document.write('        <option value="length.htm">Length</option>' + "\n");
document.write('        <option value="light.htm">Light</option>' + "\n");
document.write('        <option value="weight.htm">Mass</option>' + "\n");
document.write('        <option value="map_category.htm">Mapping</option>' + "\n");
document.write('        <option value="misc.htm">Misc</option>' + "\n");
document.write('        <option value="numbers.htm">Numbers</option>' + "\n");
document.write('        <option value="power.htm">Power</option>' + "\n");
document.write('        <option value="pressure.htm">Pressure</option>' + "\n");
document.write('        <option value="speed.htm">Speed</option>' + "\n");
document.write('        <option value="temperature.htm">Temperature</option>' + "\n");
document.write('        <option value="torque.htm">Torque</option>' + "\n");
document.write('        <option value="date_time.htm">Time/Date</option>' + "\n");
document.write('        <option value="viscosity.htm">Viscosity</option>' + "\n");
document.write('        <option value="volume.htm">Volume</option>' + "\n");
document.write('        <option value="weight.htm">Weight</option>' + "\n");
document.write('        <option value="0">----------</option>' + "\n");
document.write('        <option value="contact.htm">Contact</option>' + "\n");
document.write('        <option value="license.htm">License</option>' + "\n");
document.write('        <option value="new.htm">Whats New</option>' + "\n");
document.write('      </select></p>' + "\n");
document.write('    </form>' + "\n");
document.write("\n");
}

