package za.co.mmagon.jwebswing.utilities;

import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/*
import hirondelle.web4j.security.SafeText;
import hirondelle.web4j.ui.translate.Text;
import hirondelle.web4j.ui.translate.Tooltips;
import hirondelle.web4j.ui.translate.TextFlow;
import hirondelle.web4j.ui.tag.Populate;
import hirondelle.web4j.database.Report;*

/**
 Convenience methods for escaping special characters related to HTML, XML, 
 and regular expressions.
 
 &lt;P&gt;To keep you safe by default, WEB4J goes to some effort to escape 
 characters in your data when appropriate, such that you &lt;em&gt;usually&lt;/em&gt;
 don't need to think too much about escaping special characters. Thus, you
  shouldn't need to &lt;em&gt;directly&lt;/em&gt; use the services of this class very often. 
 
 &lt;P&gt;&lt;span class='highlight'&gt;For Model Objects containing free form user input, 
 it is highly recommended that you use {@link SafeText}, not &lt;tt&gt;String&lt;/tt&gt;&lt;/span&gt;.
 Free form user input is open to malicious use, such as
 &lt;a href='http://www.owasp.org/index.php/Cross_Site_Scripting'&gt;Cross Site Scripting&lt;/a&gt;
 attacks. 
 Using &lt;tt&gt;SafeText&lt;/tt&gt; will protect you from such attacks, by always escaping 
 special characters automatically in its &lt;tt&gt;toString()&lt;/tt&gt; method.   
 
 &lt;P&gt;The following WEB4J classes will automatically escape special characters 
 for you, when needed : 
 &lt;ul&gt;
 &lt;li&gt;the {@link SafeText} class, used as a building block class for your 
 application's Model Objects, for modeling all free form user input
 &lt;li&gt;the {@link Populate} tag used with forms
 &lt;li&gt;the {@link Report} class used for creating quick reports
 &lt;li&gt;the {@link Text}, {@link TextFlow}, and {@link Tooltips} custom tags used 
 for translation
 &lt;/ul&gt; 
*/
public final class EscapeChars {

  /**
    Escape characters for text appearing in HTML markup.
    
    &lt;P&gt;This method exists as a defence against Cross Site Scripting (XSS) hacks.
    The idea is to neutralize control characters commonly used by scripts, such that
    they will not be executed by the browser. This is done by replacing the control
    characters with their escaped equivalents.  
    See {link hirondelle.web4j.security.SafeText} as well.
   */
   public static String forHTML(String aText){
     final StringBuilder result = new StringBuilder();
     final StringCharacterIterator iterator = new StringCharacterIterator(aText);
     char character =  iterator.current();
     while (character != CharacterIterator.DONE ){
       if (character == '<') {
         result.append("&lt;");
       }
       else if (character == '>') {
         result.append("&gt;");
       }
       else if (character == '&') {
         result.append("&amp;");
      }
       else if (character == '\"') {
         result.append("&quot;");
       }
       else if (character == '\t') {
         addCharEntity(9, result);
       }
       else if (character == '!') {
         addCharEntity(33, result);
       }
       else if (character == '#') {
         addCharEntity(35, result);
       }
       else if (character == '$') {
         addCharEntity(36, result);
       }
       else if (character == '%') {
         addCharEntity(37, result);
       }
       else if (character == '\'') {
         addCharEntity(39, result);
       }
       else if (character == '(') {
         addCharEntity(40, result);
       }
       else if (character == ')') {
         addCharEntity(41, result);
       }
       else if (character == '*') {
         addCharEntity(42, result);
       }
       else if (character == '+') {
         addCharEntity(43, result);
       }
       else if (character == ',') {
         addCharEntity(44, result);
       }
       else if (character == '-') {
         addCharEntity(45, result);
       }
       else if (character == '.') {
         addCharEntity(46, result);
       }
       else if (character == '/') {
         addCharEntity(47, result);
       }
       else if (character == ':') {
         addCharEntity(58, result);
       }
       else if (character == ';') {
         addCharEntity(59, result);
       }
       else if (character == '=') {
         addCharEntity(61, result);
       }
       else if (character == '?') {
         addCharEntity(63, result);
       }
       else if (character == '@') {
         addCharEntity(64, result);
       }
       else if (character == '[') {
         addCharEntity(91, result);
       }
       else if (character == '\\') {
         addCharEntity(92, result);
       }
       else if (character == ']') {
         addCharEntity(93, result);
       }
       else if (character == '^') {
         addCharEntity(94, result);
       }
       else if (character == '_') {
         addCharEntity(95, result);
       }
       else if (character == '`') {
         addCharEntity(96, result);
       }
       else if (character == '{') {
         addCharEntity(123, result);
       }
       else if (character == '|') {
         addCharEntity(124, result);
       }
       else if (character == '}') {
         addCharEntity(125, result);
       }
       else if (character == '~') {
         addCharEntity(126, result);
       }
       else {
         //the char is not a special one
         //add it to the result as is
         result.append(character);
       }
       character = iterator.next();
     }
     return result.toString();
  }
  

  /**
   Escape all ampersand characters in a URL. 
*/
  public static String forHrefAmpersand(String aURL){
    return aURL.replace("&", "&amp;");
  }

   public static String forURL(String aURLFragment){
     String result = null;
     try {
       result = URLEncoder.encode(aURLFragment, "UTF-8");
     }
     catch (UnsupportedEncodingException ex){
       throw new RuntimeException("UTF-8 not supported", ex);
     }
     return result;
   }

  /**
   Escape characters for text appearing as XML data, between tags.
*/
  public static String forXML(String aText){
    final StringBuilder result = new StringBuilder();
    final StringCharacterIterator iterator = new StringCharacterIterator(aText);
    char character =  iterator.current();
    while (character != CharacterIterator.DONE ){
      if (character == '<') {
        result.append("&lt;");
      }
      else if (character == '>') {
        result.append("&gt;");
      }
      else if (character == '\"') {
        result.append("&quot;");
      }
      else if (character == '\'') {
        result.append("&#039;");
      }
      else if (character == '&') {
         result.append("&amp;");
      }
      else {
        //the char is not a special one
        //add it to the result as is
        result.append(character);
      }
      character = iterator.next();
    }
    return result.toString();
  }
  
  /**
   Escapes characters for text appearing as data in the 
  */
  public static String forJSON(String aText){
    final StringBuilder result = new StringBuilder();
    StringCharacterIterator iterator = new StringCharacterIterator(aText);
    char character = iterator.current();
    while (character != StringCharacterIterator.DONE){
      if( character == '\"' ){
        result.append("\\\"");
      }
      else if(character == '\\'){
        result.append("\\\\");
      }
      else if(character == '/'){
        result.append("\\/");
      }
      else if(character == '\b'){
        result.append("\\b");
      }
      else if(character == '\f'){
        result.append("\\f");
      }
      else if(character == '\n'){
        result.append("\\n");
      }
      else if(character == '\r'){
        result.append("\\r");
      }
      else if(character == '\t'){
        result.append("\\t");
      }
      else {
        //the char is not a special one
        //add it to the result as is
        result.append(character);
      }
      character = iterator.next();
    }
    return result.toString();    
  }

  /**
   Returns opening and closing tags replaced with the HTML Equivalents
   replaced by their escaped equivalents.
  */
  public static String toDisableTags(String aText){
    final StringBuilder result = new StringBuilder();
    final StringCharacterIterator iterator = new StringCharacterIterator(aText);
    char character =  iterator.current();
    while (character != CharacterIterator.DONE ){
      if (character == '<') {
        result.append("&lt;");
      }
      else if (character == '>') {
        result.append("&gt;");
      }
      else {
        //the char is not a special one
        //add it to the result as is
        result.append(character);
      }
      character = iterator.next();
    }
    return result.toString();
  }
  

  /**
   Replace characters having special meaning in regular expressions
   with their escaped equivalents, preceded by a '\' character.
  */
  public static String forRegex(String aRegexFragment){
    final StringBuilder result = new StringBuilder();

    final StringCharacterIterator iterator = 
      new StringCharacterIterator(aRegexFragment)
    ;
    char character =  iterator.current();
    while (character != CharacterIterator.DONE ){
      /*
       All literals need to have backslashes doubled.
      */
      if (character == '.') {
        result.append("\\.");
      }
      else if (character == '\\') {
        result.append("\\\\");
      }
      else if (character == '?') {
        result.append("\\?");
      }
      else if (character == '*') {
        result.append("\\*");
      }
      else if (character == '+') {
        result.append("\\+");
      }
      else if (character == '&') {
        result.append("\\&");
      }
      else if (character == ':') {
        result.append("\\:");
      }
      else if (character == '{') {
        result.append("\\{");
      }
      else if (character == '}') {
        result.append("\\}");
      }
      else if (character == '[') {
        result.append("\\[");
      }
      else if (character == ']') {
        result.append("\\]");
      }
      else if (character == '(') {
        result.append("\\(");
      }
      else if (character == ')') {
        result.append("\\)");
      }
      else if (character == '^') {
        result.append("\\^");
      }
      else if (character == '$') {
        result.append("\\$");
      }
      else {
        //the char is not a special one
        //add it to the result as is
        result.append(character);
      }
      character = iterator.next();
    }
    return result.toString();
  }
  
  /**
   Escape <tt>'$'</tt> and <tt>'\'</tt> characters in replacement strings.
  */
  public static String forReplacementString(String aInput){
    return Matcher.quoteReplacement(aInput);
  }
  
  /**
   Disable all script tags
  */  
  public static String forScriptTagsOnly(String aText){
    String result = null;
    Matcher matcher = SCRIPT.matcher(aText);
    result = matcher.replaceAll("&gt;SCRIPT&lt;");
    matcher = SCRIPT_END.matcher(result);
    result = matcher.replaceAll("&gt;/SCRIPT&lt;");
    return result;
  }
  
  // PRIVATE //
  
  private EscapeChars(){
    //empty - prevent construction
  }
  
  private static final Pattern SCRIPT = Pattern.compile(
    "<SCRIPT>", Pattern.CASE_INSENSITIVE
   );
  private static final Pattern SCRIPT_END = Pattern.compile(
    "</SCRIPT>", Pattern.CASE_INSENSITIVE
  );
  
  private static void addCharEntity(Integer aIdx, StringBuilder aBuilder){
    String padding = "";
    if( aIdx <= 9 ){
       padding = "00";
    }
    else if( aIdx <= 99 ){
      padding = "0";
    }
    else {
      //no prefix
    }
    String number = padding + aIdx.toString();
    aBuilder.append("&#").append(number).append(";");
  }
}