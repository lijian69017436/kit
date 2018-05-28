级联插件
var urlChina = 'fileDataSource?sectionId='+sectionId;
              $.cxSelect.defaults.url = urlChina; 
              $('#city_china_val').cxSelect({
                  selects: ['province', 'city', 'area'],
                  jsonName: 'n', 
                    jsonValue: 'v', 
                    jsonSub: 's'
              });