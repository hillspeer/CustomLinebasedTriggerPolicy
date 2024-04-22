## Installation

install a custom TriggerPolicy, use the configured log4j2.xml file
For logstash connection, SocketAppender to be used, also available in log4j2.xml

## Dependencies

jackson-databind for json representation of logs

## Usage

### configuration at log stash binary
cd /opt/logstash-8.6.1
cat config/logstash-sample.conf
cat logs/logstash-plain.log
vi config/logstash-sample.conf
cat logs/logstash-plain.log
cat logs/logstash-plain.log
bin/logstash-plugin install --no-verify
vi config/logstash-sample.conf

### configuration at plugin location
git clone https://github.com/logstash-plugins/logstash-filter-cipher.git
cd logstash-filter-cipher/
gem "logstash-filter-cipher", :path => "/home/kaderhillsonpeer/development/logstash-filter-cipher"
gem build spec/logstash-filter-cipher.gemspec
gem build logstash-filter-cipher.gemspec