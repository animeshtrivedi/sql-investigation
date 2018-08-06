package org.apache.spark.rpc.darpc

import org.apache.spark.SparkConf
import org.apache.spark.internal.Logging
import org.apache.spark.rpc.{RpcEndpoint, RpcEndpointRef, RpcEnv}
import org.apache.spark.serializer.JavaSerializerInstance

/**
  * Created by atr on 06.08.18.
  */
class DarpcRpcEnv (val conf: SparkConf) extends RpcEnv(conf) with Logging {
  /**
    * Return RpcEndpointRef of the registered [[RpcEndpoint]]. Will be used to implement
    * [[RpcEndpoint.self]]. Return `null` if the corresponding [[RpcEndpointRef]] does not exist.
    */
  override private[rpc] def endpointRef(endpoint: RpcEndpoint) = ???

  /**
    * Return the address that [[RpcEnv]] is listening to.
    */
  override def address = ???

  /**
    * Register a [[RpcEndpoint]] with a name and return its [[RpcEndpointRef]]. [[RpcEnv]] does not
    * guarantee thread-safety.
    */
  override def setupEndpoint(name: String, endpoint: RpcEndpoint) = ???

  /**
    * Retrieve the [[RpcEndpointRef]] represented by `uri` asynchronously.
    */
  override def asyncSetupEndpointRefByURI(uri: String) = ???

  /**
    * Stop [[RpcEndpoint]] specified by `endpoint`.
    */
  override def stop(endpoint: RpcEndpointRef) = ???

  /**
    * Shutdown this [[RpcEnv]] asynchronously. If need to make sure [[RpcEnv]] exits successfully,
    * call [[awaitTermination()]] straight after [[shutdown()]].
    */
  override def shutdown() = ???

  /**
    * Wait until [[RpcEnv]] exits.
    *
    * TODO do we need a timeout parameter?
    */
  override def awaitTermination() = ???

  /**
    * [[RpcEndpointRef]] cannot be deserialized without [[RpcEnv]]. So when deserializing any object
    * that contains [[RpcEndpointRef]]s, the deserialization codes should be wrapped by this method.
    */
  override def deserialize[T](deserializationAction: () => T) = ???

  /**
    * Return the instance of the file server used to serve files. This may be `null` if the
    * RpcEnv is not operating in server mode.
    */
  override def fileServer = ???

  /**
    * Open a channel to download a file from the given URI. If the URIs returned by the
    * RpcEnvFileServer use the "spark" scheme, this method will be called by the Utils class to
    * retrieve the files.
    *
    * @param uri URI with location of the file.
    */
  override def openChannel(uri: String) = ???
}
