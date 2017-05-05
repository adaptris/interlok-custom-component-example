# service-example
A quick start to writing your own services; but this time behind a proxy server.

* Uses ant with ivy for dependency management
* `ant test` creates the jar.
* Modify build.xml so that your computername is part of the `condition`
   * We standardise on env.COMPUTERNAME so it's right for windows + linux
* ant -Dproxy.host=my host -Dproxy.port=3128 compile