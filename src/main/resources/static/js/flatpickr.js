let maxDate = new Date();
maxDate.setMonth(maxDate.getMonth() + 2);

flatpickr('#fromCheckinDateToCheckinTime', {
  mode: "single",
  locale: 'ja',
  minDate: 'today',
  maxDate: maxDate
});