# Intro
Formation is a configuration library for Clojure projects following simple conventions, it enables:

* Loading edn files from ~/.{project}.edn or /etc/{project}/{project}.edn (by order).
* Running [validations](https://github.com/narkisr/substantiation) on the configuration.
* Spitting out errors in pretty printed form into both stdout/[timbre](https://github.com/ptaoussanis/timbre).

# Usage
Formation expects the following keys in the edn file (for project named foo):

```clojure
{
 :foo {
  :log {:path "/var/log/foo.log"}
 }
}
```

Loading and validating:

```clojure
(defn validate [c]
 ; using any validation framework with structured error output
 )
(config "foo" validate)
```

# Copyright and license
Copyright [2014] [Ronen Narkis]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
