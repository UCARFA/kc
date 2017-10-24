

## Database Changes

 - [ ] All changes are backwards compatible (unless already released, do not delete tables/columns or move data such that previous versions of the application cannot function with this change)
 - [ ] Database changes are numbered correctly (YYMM_###). All changes must be numbered with the year and month they are merged. All version numbers must be unique within the year and month at the time they are merged.
 - [ ] Both Oracle and Mysql scripts are included
 - [ ] Bootstrap data uses hard-coded primary keys whenever possible
 - [ ] Rice and KC changes are separate and in correct folders
 - See [coeus-db-sql README](https://github.com/kualico/kc/blob/master/coeus-db/coeus-db-sql/README.md) for additional requirements of SQL scripts

## Tests

 - [ ] Unit tests for modified code are included
 - [ ] Integration tests are included whenever possible

## Code

 - [ ] Clean, readable and maintain-able code
 - [ ] Uses spring injection and auto-wiring when possible
 - [ ] Uses Java 8 features when appropriate, using Streams and functional style programming whenever possible
 - [ ] Duplication of code is minimized
 - [ ] New features are feature-flagged (if unsure if necessary seek functional guidance)
 
## API or Service Dependencies

 - [ ] All api changes are documented
 - [ ] API changes are backwards compatible (adding, never removing data or features) or are versioned as a new version of the api
 - [ ] All API changes or new service level api dependencies are documented in the CHANGELOG_API.md
 
## Accessibility

 - [ ] All changes are accessible and meet the requirements of WCAG to the best extent possible

## Security

 - [ ] All code is secure (see [OWASP top 10](https://www.owasp.org/index.php/Top_10_2013-Top_10) for potential vulnerabilities to review for)
 
## Performant

 - [ ] All code appears to be performant and will operate reasonably even with large data sets
 
## Deprecated Modules

 - [ ] Code is a critical bug fix if for any deprecated modules (COI, IRB, IACUC, BIRT)