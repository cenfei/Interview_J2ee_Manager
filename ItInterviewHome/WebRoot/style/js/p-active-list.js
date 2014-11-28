$(function() {
	//alert();
	//$(".pop-bg").addClass("pop-bg--show");
	var filter = {
		obj: {
			main: $(".btn-toolbar-box"),
			btn: $(".btn-toolbar-box").find(".btn"),
			popBox: $(".pop-bg-filter"),
			pop: $(".pop-bg-filter .pop"),
			popTit: $(".pop-bg-filter .pop").find(".panel-title .pager .tit"),
			popCurInput: $(),
			popList: $(),
			listBox: $(".list-box-hide")
		},
		opt: {
			main:".btn-toolbar-box",
			btn:".btn",
			pop:".pop-bg-filter .pop",
			popBox:".pop-bg-filter",
			popBoxShow: ".pop-bg--show",
			popBoxShowClass: "pop-bg--show",
			popListItem: ".list-group-item",
			popListItemCur: ".list-group-item-selected",
			popListItemCurClass: "list-group-item-selected",
			
			listBoxHide: ".list-box-hide",
			
			popCurId: ""
		},
		init: function() {
			this.event();
			this.addLight();
		},
		event: function() {
			var module = this;
			this.obj.main.on("click",".btn",function(){
				module.eventBtn($(this));
			});
			
			
			//pop相关
			this.obj.pop.on("click",".list-group-item",function(){
				module.popListItemSelect($(this));
			});
			
			this.obj.pop.on("click",".panel-heading .panel-title .pager .previous",function(){
				module.popHide();
			});
			
			this.obj.pop.on("click",".panel-heading .panel-title .pager .next",function(){
				//alert("刷新页面数据，记得约定的是刷新");
				module.popListItemSelect2input();
				module.popHide();
			});
			
			
			
		},
		eventBtn: function($this) {
			this.popTit(this.getPopTit($this));
			this.popChangeId($this);
			this.popChangeData($this);
			this.popItemCurLight();
			this.popShow();
		},
		popShow: function() {
			this.obj.popBox.addClass(this.opt.popBoxShowClass);
		},
		popHide: function() {
			this.obj.popBox.removeClass(this.opt.popBoxShowClass);
		},
		popListItemSelect: function($this) {
//			debugger;
			$this.toggleClass(this.opt.popListItemCurClass);
			
		},
		popListItemSelect2input: function() {
			var result = this.obj.pop.find(this.opt.popListItemCur).map(function() {
				return $(this).data("val");
			}).get().join("|");
			this.obj.popCurInput.val(result);
			//alert(this.obj.popCurInput.attr("id"));
			//alert(this.obj.popCurInput.val());
			/**
			 * fox添加哦
			 */
			document.selectForm.submit();
		},
		popChangeId: function($this) {
			var class$this = $this.attr("class");
			var classId = class$this.match(/btn-id-(\w*)/)[1];
			this.opt.popCurId = classId;
			this.obj.popCurInput = $("#"+classId);
			this.obj.popBox.addClass("pop-bg-"+classId);
		},
		popChangeData: function($this) {
			var objList = this.obj.listBox.find(".list-id-"+ this.opt.popCurId);
			var objBox = $(".pop-bg-filter").find(".panel-body");
			objBox.html("");
			this.obj.popList = objList.clone().appendTo(objBox);
//			console.log(this.obj.popList);
		},
		popItemCurLight: function() {
			var val = this.obj.popCurInput.val();
			if (val) {
				var arrVal = val.split("|");
				var arrListItem = this.obj.popList.find(this.opt.popListItem);
//				$.grep(arrListItem,function(e,i){
//					debugger;
//				});
				for ( var i = 0; i < arrVal.length; i++) {
					arrListItem.filter("[data-val="+arrVal[i]+"]").addClass(this.opt.popListItemCurClass);
				}
				
				
				
			}
		},
		popTit: function(tit) {
			this.obj.popTit.html(tit);
		},
		getPopTit: function($this) {
			return $this.html();
		},
		addLight: function() {
			if($("#city").val()&&$("#city").val()!="||"){
				$(".btn-id-city").addClass("btn-info");
			};
			if($("#year").val()&&$("#year").val()!="||"){
				$(".btn-id-year").addClass("btn-info");
			};
			if($("#college").val()&&$("#college").val()!="||"){
				$(".btn-id-college").addClass("btn-info");
			};
			if($("#trade").val()&&$("#trade").val()!="||"){
				$(".btn-id-trade").addClass("btn-info");
			};
			if($("#time").val()&&$("#time").val()!="||"){
				$(".btn-id-time").addClass("btn-info");
			};
			if($("#location").val()&&$("#location").val()!="||"){
				$(".btn-id-location").addClass("btn-info");
			};
			if($("#time").val()&&$("#time").val()!="||"){
				$(".btn-id-time").addClass("btn-info");
			};
			if($("#activeType").val()&&$("#activeType").val()!="||"){
				$(".btn-id-activeType").addClass("btn-info");
			};
		}
	};
	
	filter.init();
	
	
	
});