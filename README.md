# service-example
A quick start to writing your own services; but this time behind a proxy server.

* Uses ant with ivy for dependency management
* Modify build.xml so that your computername is part of the `condition`
   * We standardise on env.COMPUTERNAME so it's right for windows + linux
   * If on linux, use the output of `hostname`
   * We do it like this so that some machines can optionally not be behind the proxy.
```
    <condition property="requires.proxy" value="true">
      <or>
        <equals arg1="${env.COMPUTERNAME}" arg2="my.computer.name"/>
      </or>
    </condition>
```
* `ant -Dproxy.host=my host -Dproxy.port=3128` compile
* `ant test` creates the jar (pass in properties)
