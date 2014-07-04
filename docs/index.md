<!-- Generated using template product-user-guide-template.mdtoc -->
<!-- Generated using template product-user-guide-template.md -->
<h1 id="psexplorer-user-guide">PSExplorer User Guide</h1>


<h2 id="table-of-contents">Table of Contents</h2>

<div id="toc">
  <ul>
    <li>
      <a href="#introduction">Introduction</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li>
          <a href="#system-requirements">System Requirements</a>
        </li>
        <li>
          <a href="#rights">Rights</a>
        </li>
        <li>
          <a href="#installation">Installation</a>
        </li>
      </ul>

    </li>
    <li>
      <a href="#data-fields">Data Fields</a>
    </li>
    <li>
      <a href="#user-interface">User Interface</a>
      <ul>
        <li>
          <a href="#textmerge-sort">TextMerge Sort</a>
        </li>
      </ul>

    </li>
  </ul>

</div>


<h2 id="introduction">Introduction</h2>


PSExplorer displays helpful information about the user's environment. Such information may help explain why other PowerSurge Publishing applications are having difficulty executing successfully.


<h2 id="getting-started">Getting Started</h2>


<h3 id="system-requirements">System Requirements</h3>


PSExplorer is written in Java and can run on any reasonably modern operating system, including Mac OS X, Windows and Linux. PSExplorer requires a Java Runtime Environment (JRE), also known as a Java Virtual Machine (JVM). The version of this JRE/JVM must be at least 6. Visit [www.java.com](http://www.java.com) to download a recent version for most operating systems. Installation happens a bit differently under Mac OS X, but generally will occur fairly automatically when you try to launch a Java app for the first time.

Because PSExplorer may be run on multiple platforms, it may look slightly different on different operating systems, and will obey slightly different conventions (using the CMD key on a Mac, vs. an ALT key on a PC, for example).

<h3 id="rights">Rights</h3>


PSExplorer Copyright 2004 - 2014 by Herb Bowie

PSExplorer is [open source software](http://opensource.org/osd). Source code is available at [GitHub](http://github.com/hbowie/psexplorer).

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

  [www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.


<h3 id="installation">Installation</h3>


Download the latest version from [PowerSurgePub.com](http://www.powersurgepub.com/downloads.html). Decompress the downloaded file. Drag the resulting file or folder into the location where you normally store your applications. Double-click on the jar file (or the application, if you've downloaded the Mac app) to launch.


<h2 id="data-fields">Data Fields</h2>


PSExplorer works with system variables and parameters.

<h2 id="user-interface">User Interface</h2>



<>if  eq yes ?>

<h3 id="textmerge-sort">TextMerge Sort</h3>


This tab allows the user to sort the data that has been input. Sorting is accomplished by using the following buttons that appear on this tab.

<h4 id="field-name">Field Name</h4>


This is a drop down list of all the columns in your data. Select the next field name on which you wish to sort, by starting with the most significant fields and proceeding to less significance.

<h4 id="sort-sequence">Sort Sequence</h4>


This is a drop down list. Pick either ascending (lower values towards the top, higher values towards the bottom) or descending. This sequence applies to the currently selected field name (see above).

<h4 id="add">Add</h4>


Pressing this button will add the field and sequence currently specified to the current sort parameters being built. The sort parameters added will appear in the text area shown below on this tab. After pressing the Add button, the user may go back and specify additional fields to be used in the sort criteria.

<h4 id="clear">Clear</h4>


Pressing this button will clear the sort parameters being built, so that you can start over.

<h4 id="set">Set</h4>


Once your desired sort parameters have been completely built, by pressing the Add button one or more times, you must press the Set button to cause your parameters to be applied to the data you are currently processing.

<h4 id="combine">Combine</h4>


After setting the desired sort sequence, you may optionally press this button to combine records with duplicate sort keys. The following buttons allow you to adjust the parameters controlling the combination process.

<h4 id="tolerance-for-data-loss">Tolerance for Data Loss</h4>


Record combination can be done with varying degrees of tolerance for data loss. Select one of the following radio buttons.

* No Data Loss &#8212; Records will only be combined if data (non-key) fields are identical, or if one of the two corresponding values is blank (in which case the non-blank value will be preserved in the resulting combined record).
* Later Records Override Earlier &#8212; If you are merging two input files, and one is known to carry more current data, then you can specify which file is the more current with this button or the next. This button will cause files merged later to be treated as more current.
* Earlier Records Override Later &#8212; Similar to prior button, but with files merged earlier taking precedence over later ones.
* Combine Fields Where Allowed &#8212; If the data dictionary allows fields to be concatenated, then this radio button indicates that concatenation may take place. This may be appropriate for a comment field.


<h4 id="minimum-number-of-lossless-fields">Minimum Number of Lossless Fields</h4>


If you specify some data loss to be acceptable, then this field may be used to specify a minimum number of data (non-key) fields that must be lossless (equal or one blank) before combination will be allowed to take place. This should be used if the sort keys are not guaranteed to establish uniqueness. Specifying a non-zero value here may help to prevent completely disparate records from being inadvertently combined. For example, names can be used to identify people, but two different people may have the same name.

Increment (+)
:    Use this button to increase the minimum number of lossless fields.

Decrement (-)
:    Use this button to decrease the minimum number of lossless fields. Zero is the smallest allowable value.

[java]:       http://www.java.com/
[pspub]:      http://www.powersurgepub.com/
[downloads]:  http://www.powersurgepub.com/downloads.html
[osd]:		  http://opensource.org/osd
[gnu]:        http://www.gnu.org/licenses/
[apache]:	     http://www.apache.org/licenses/LICENSE-2.0.html
[markdown]:		http://daringfireball.net/projects/markdown/
[multimarkdown]:  http://fletcher.github.com/peg-multimarkdown/

[wikiq]:     http://www.wikiquote.org
[support]:   mailto:support@powersurgepub.com
[fortune]:   http://en.wikipedia.org/wiki/Fortune_(Unix)
[opml]:      http://en.wikipedia.org/wiki/OPML
[textile]:   http://en.wikipedia.org/wiki/Textile_(markup_language)
[pw]:        http://www.portablewisdom.org

[store]:     http://www.powersurgepub.com/store.html

[pegdown]:   https://github.com/sirthias/pegdown/blob/master/LICENSE
[parboiled]: https://github.com/sirthias/parboiled/blob/master/LICENSE
[Mathias]:   https://github.com/sirthias

[club]:         clubplanner.html
[filedir]:      filedir.html
[metamarkdown]: metamarkdown.html
[template]:     template.html

[mozilla]:    http://www.mozilla.org/MPL/2.0/


