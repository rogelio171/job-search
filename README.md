# Job Search CLI

<img src="https://img.shields.io/hexpm/l/apa" />

## Overview

This application generates a CLI that makes requests to the GitHub Jobs API.

## How to generate the CLI

To have an executable application you need to run the Gradle task:
_distribution/distZip_ and unzip the files.

## Usage

After the application is unzipped, go to the `/bin` directory and run 
the following command:

`job-search [options] A search term, such as "python" or "java".`

 Options:
> `--full-time`
      If you want to limit results to full time positions set this parameter 
      to 'true'. Default: false

> `--help` Shows the help.

> `--location, -l` A city name, zip code, or other location search term.
   
> `--markdown, -md` Show the description and how_to_apply fields as Markdown.
      Default: false
   
> `--page, -p` Each page will only return 50 positions at a time.
