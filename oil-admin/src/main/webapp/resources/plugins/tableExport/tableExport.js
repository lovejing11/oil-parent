	function expTable(sheetName) { 
					var excelFile2 = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
					excelFile2+="<meta http-equiv=Content-Type content=\"text/html; charset=gb2312\">"
				    excelFile2 += "<head>";
					excelFile2+="<style> tr th{border-left: none;border-right: 0.5pt solid #000; border-bottom: 0.5pt solid #000; text-align: center;   font-size: 10pt; middle: ;;height:30px;}  tr td{border-right: 0.5pt solid #000;border-left: none;  border-bottom: 0.5pt solid #000;text-align: center; font-weight: normal;  font-size: 10pt; middle: ;;height:30px;}</style>";
					excelFile2 += "<!--[if gte mso 9]>";
					excelFile2 += "<xml>";
					excelFile2 += "<x:ExcelWorkbook>";
					excelFile2 += "<x:ExcelWorksheets>";
					excelFile2 += "<x:ExcelWorksheet>";
					excelFile2 += "<x:Name>";
					excelFile2 += "</x:Name>";
					excelFile2 += "<x:WorksheetOptions>";
					excelFile2 += "<x:DisplayGridlines/>";
					excelFile2 += "</x:WorksheetOptions>";
					excelFile2 += "</x:ExcelWorksheet>";
					excelFile2 += "</x:ExcelWorksheets>";
					excelFile2 += "</x:ExcelWorkbook>";
					excelFile2 += "</xml>";
					excelFile2 += "</head>";
					excelFile2 += "<body>";
					excelFile2 += $("#content").html();
					excelFile2 += "</body>";
					excelFile2 += "</html>";
					var base64data = "base64," + $.base64({data:excelFile2,type:0,unicode:true});
					var downloadLink = document.createElement("a"); 
					downloadLink.href = 'data:application/vnd.ms-excel;'+base64data; 
				    downloadLink.download = sheetName+".xls"; 
					document.body.appendChild(downloadLink); 
					downloadLink.click(); 
				    document.body.removeChild(downloadLink); 
				} 