/**  ____    __    ____  ____  ____,,___     ____  __  __  ____
 *  (  _ \  /__\  (_   )(_  _)( ___)/ __)   (  _ \(  )(  )(  _ \           Read
 *   )   / /(__)\  / /_  _)(_  )__) \__ \    )___/ )(__)(  ) _ <     README.txt
 *  (_)\_)(__)(__)(____)(____)(____)(___/   (__)  (______)(____/    LICENSE.txt
 */
package razie

// NOTE --------------------- this is a limited implementation

/** 
 * some logging basics 
 * 
 * You can customize the entire logging system by providing an implementation for 
 * com.razie.pub.base.log.Factory and set that: com.razie.pub.base.log.Log.factory = new MyFactory().
 * 
 * See example in razpub:com.razie.pub.base.log.Log4j
 * 
 * @author razvanc
 */
trait Log {
   def trace (f : => Any) 
   def log   (msg:String, e:Throwable=null)
   def alarm (msg:String, e:Throwable=null) // implicit audit
   def audit (msg:String, t:Throwable=null)
   def error (msg:String, t:Throwable=null) // alarm and throw
   
   def apply (msg:String, e:Throwable=null) = log (msg, e)
} 

class StupidLog extends Log {
   override def trace (f : => Any) = println ("DEBUG" + f) 
   override def log   (msg:String, t:Throwable=null) = println ("LOG: " + msg + t)
   override def alarm   (msg:String, t:Throwable=null) = println ("ALARM: " + msg, t)
   override def audit   (msg:String, t:Throwable=null) = println ("AUDIT: " + msg, t)
   override def error   (msg:String, t:Throwable=null) = { println(msg, t); throw t }
}

/** some logging basics 
 * 
 * @author razvanc
 */
object Log extends Log {
   // overwrite this to use your own logging
   var impl = new StupidLog()
   
   override def trace (f : => Any) = impl.trace(f)
   override def log   (msg:String, t:Throwable=null) = impl.log(msg, t)
   override def alarm   (msg:String, t:Throwable=null) = impl.alarm(msg, t)
   override def audit   (msg:String, t:Throwable=null) = impl.audit(msg, t)
   override def error   (msg:String, t:Throwable=null) = impl.error(msg, t)

   def auditThis   (msg:String, t:Throwable=null) = audit (msg, t)

   def logThis (msg:String) = log (msg)
   def apply   (msg:String) = log (msg)
   def logThis (msg:String, e:Throwable) = log(msg, e)
   
   /** @return the same message, so you can return it */
   def alarmThis (msg:String) = {
      impl.alarm(msg) 
      msg
	   }
	   
   /** @return the same message, so you can return it */
   def alarmThis (msg:String, e:Throwable) = {
      impl.alarm (msg, e) 
      msg
	   }
}

object Debug {
   def apply (f : => Any) = Log.trace(f)
}
